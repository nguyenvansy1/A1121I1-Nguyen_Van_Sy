package music_app.controller;

import music_app.entity.Song;
import music_app.validator.SongValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SongController {
    @GetMapping("/")
    public ModelAndView getForm() {
        return new ModelAndView("index","song",new Song());
    }

    @PostMapping("/")
    public ModelAndView save(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        new SongValidator().validate(song,bindingResult);
        if(bindingResult.hasErrors()) {
            return new ModelAndView("index","song",song);
        }else {
            return new ModelAndView("success");
        }
    }
}
