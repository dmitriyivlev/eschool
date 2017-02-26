package ru.ddimike.eschool.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.ddimike.eschool.model.Pupil;
import ru.ddimike.eschool.validator.PupilFormValidator;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PupilController {

    @Autowired
    private SqlSession m_SqlSession;

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
    public String list(Model p_Model, HttpSession httpSession) {
        if("true".equals(httpSession.getAttribute("isLoginCorrect"))){

            List<Pupil> pupilsAllList = m_SqlSession.selectList("data-mapper.selectAllPupil");
            p_Model.addAttribute("pupilsData", pupilsAllList);
            return "list";
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model p_Model, HttpSession httpSession) {
        if("true".equals(httpSession.getAttribute("isLoginCorrect"))) {
            Pupil newPupil = new Pupil();
            p_Model.addAttribute("newPupilData", newPupil);
            populateDefaultModel(p_Model);
            return "form";
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String add(@ModelAttribute("newPupilData") @Validated Pupil newPupil, BindingResult result,
                      Model p_Model, HttpSession httpSession) {

        if("true".equals(httpSession.getAttribute("isLoginCorrect"))) {
            if (result.hasErrors()) {
                populateDefaultModel(p_Model);
                return "form";
            } else {
                m_SqlSession.insert("data-mapper.insertPupil", newPupil);

                return "redirect:/list";
            }
        }
        else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/delete/{pupilId}")
    public String delete(@PathVariable("pupilId") Integer pupilId) {
        m_SqlSession.delete("data-mapper.deletePupil", pupilId);

        return "redirect:/list";
    }

    private void populateDefaultModel(Model model) {
        List<Integer> classNumbers = new ArrayList<Integer>();
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

        List<String> classLetters = new ArrayList<String>();
        classLetters.add("А");
        classLetters.add("Б");
        classLetters.add("В");
        classLetters.add("Г");
        model.addAttribute("classLetters", classLetters);
    }

}
