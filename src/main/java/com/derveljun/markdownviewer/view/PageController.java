package com.derveljun.markdownviewer.view;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {

    final String filePath = "D:\\OneDrive\\01. 개인\\프로그래밍\\Algorithm";

    ResourceLoader resourceLoader;

    public PageController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) throws IOException {

        List<String> files = Files.list(Paths.get(filePath))
                .map(file -> file.getFileName().toString())
                .collect(Collectors.toList());

        model.addAttribute("files", files);

        return "index";
    }

    @GetMapping("/markdown/{markdownFileName}")
    public String markdown(@PathVariable String markdownFileName, Model model) throws IOException {

        String markdown = Files.readString(Paths.get(filePath + "//" + markdownFileName), Charset.forName("UTF-8"));

        model.addAttribute("markdown", markdown);
        return "markdown";
    }

}
