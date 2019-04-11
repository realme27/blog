package com.realme.controller;

import com.realme.domain.User;
import com.realme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
            model.addAttribute("userList",userRepository.getList());
            model.addAttribute("title","用户管理");

            return new ModelAndView("users/list","userModel",model);
        }
        @RequestMapping("{id}")
        @ResponseBody
        public ModelAndView view(Model model, @PathVariable("id") int id){
            model.addAttribute("user",userRepository.getUserById(id));
            model.addAttribute("title","查看用户");

            return new ModelAndView("users/view","userModel",model);
        }
        @RequestMapping("/form")
        @ResponseBody
        public ModelAndView createForm(Model model){
            model.addAttribute("user",new User());
            model.addAttribute("title","创建用户");

         return new ModelAndView("users/form","userModel",model);
        }
        @RequestMapping("/save")
        @ResponseBody
        public ModelAndView saveOrUpdate(User user){
            userRepository.saveOrUpdate(user);

            return new ModelAndView("redirect:/users");
         }
         @RequestMapping("/deleter/{id}")
        public ModelAndView delete(Model model,@PathVariable("id") int id){

                userRepository.delete(id);
            return new ModelAndView("redirect:/users");
         }
         @RequestMapping("/modify")
         public ModelAndView modify(Model model,@PathVariable("id") int id){
                User user = userRepository.getUserById(id);
                model.addAttribute("user",user);
                model.addAttribute("title","修改用户");
                return new ModelAndView("users/modify","userModel",model);
         }


}
