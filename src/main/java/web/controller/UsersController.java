package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDaoImpl usersDAO;

    public UsersController(UserDaoImpl usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", usersDAO.getListOfUsers());
        return "users/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersDAO.getUserById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";
        usersDAO.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", usersDAO.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
        public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") long id) {
        if (bindingResult.hasErrors())
            return "users/edit";
        usersDAO.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        usersDAO.deleteUserById(id);
        return "redirect:/users";
    }
}
