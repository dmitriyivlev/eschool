package ru.ddimike.eschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.ddimike.eschool.model.Pupil;
import ru.ddimike.eschool.service.PupilService;
import ru.ddimike.eschool.validator.PupilFormValidator;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PupilController {

    @Autowired
    PupilService pupilService;

    @Autowired
    PupilFormValidator pupilFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        webDataBinder.setValidator(pupilFormValidator);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, HttpSession httpSession) {
        if("true".equals(httpSession.getAttribute("isLoginCorrect"))){

            List<Pupil> pupilsAllList = pupilService.findAll();
            model.addAttribute("pupilsData", pupilsAllList);
            return "list";
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, HttpSession httpSession) {
        if("true".equals(httpSession.getAttribute("isLoginCorrect"))) {
            Pupil newPupil = new Pupil();
            model.addAttribute("newPupilData", newPupil);
            populateDefaultModel(model);
            return "form";
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String add(@ModelAttribute("newPupilData") @Validated Pupil newPupil, BindingResult result,
                      Model model, HttpSession httpSession) {

        if("true".equals(httpSession.getAttribute("isLoginCorrect"))) {
            if (result.hasErrors()) {
                populateDefaultModel(model);
                return "form";
            } else {
                pupilService.add(newPupil);

                return "redirect:/list";
            }
        }
        else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/delete/{pupilId}")
    public String delete(@PathVariable("pupilId") Integer pupilId) {
        pupilService.delete(pupilId);

        return "redirect:/list";
    }

    private void populateDefaultModel(Model model) {
        List<Integer> classNumbers = new ArrayList<>();
        classNumbers.add(1);
        classNumbers.add(2);
        classNumbers.add(3);
        classNumbers.add(4);
        classNumbers.add(5);
        classNumbers.add(6);
        classNumbers.add(7);
        classNumbers.add(8);
        classNumbers.add(9);
        classNumbers.add(10);
        classNumbers.add(11);
        model.addAttribute("classNumbers", classNumbers);

        List<String> classLetters = new ArrayList<>();
        classLetters.add("А");
        classLetters.add("Б");
        classLetters.add("В");
        classLetters.add("Г");
        model.addAttribute("classLetters", classLetters);

    }

}
