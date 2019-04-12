package com.realme.controller;

import com.realme.domain.User;
import com.realme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 *  break
 */
@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired
        private UserRepository userRepository;
        @RequestMapping
        @ResponseBody
        public ModelAndView list(Model model){
            model.addAttribute("userList",userRepository.findAll());
            model.addAttribute("title","用户管理");

            return new ModelAndView("users/list","userModel",model);
        }
        @RequestMapping("/{id}")
        @ResponseBody
        public ModelAndView view(Model model, @PathVariable("id") int id){
            model.addAttribute("user",userRepository.findById(id));
            model.addAttribute("title","查看用户");

            return new ModelAndView("users/view","userModel",model);
        }
        @RequestMapping("/form")
        @ResponseBody
        public ModelAndView createForm(Model model){
            model.addAttribute("user",new User(0,null,null));
            model.addAttribute("title","创建用户");
         return new ModelAndView("users/form","userModel",model);
        }
        @PostMapping
        @ResponseBody
        public ModelAndView saveOrUpdate(User user){
            userRepository.save(user);

            return new ModelAndView("redirect:/users");
         }
         @RequestMapping("/deleter/{id}")
        public ModelAndView delete(@PathVariable("id") int id){

                userRepository.deleteById(id);
            return new ModelAndView("redirect:/users");
         }
         @RequestMapping("/modify/{id}")
         public ModelAndView modify(Model model,@PathVariable("id") int id){
                  Optional<User> user = userRepository.findById(id);
                model.addAttribute("user",user);
                model.addAttribute("title","修改用户");
                return new ModelAndView("users/modify","userModel",model);
         }


}
