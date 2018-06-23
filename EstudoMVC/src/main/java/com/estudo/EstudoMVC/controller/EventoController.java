package com.estudo.EstudoMVC.controller;

import com.estudo.EstudoMVC.entity.Evento;
import com.estudo.EstudoMVC.repository.EventoRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ModelAndView showEvento() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Evento> eventos = eventoRepository.findAll();
        modelAndView.addObject("eventos",eventos);
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarEvento",method = RequestMethod.GET)
    public String formEvento(){
        return "evento/formulario";
    }

    @RequestMapping(value = "/cadastrarEvento",method = RequestMethod.POST)
    public String formEvento(@Valid Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public void deleteEvento() {

    }
}
