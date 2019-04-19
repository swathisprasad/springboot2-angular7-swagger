package com.swathisprasad.springboot.controller;

import com.swathisprasad.springboot.dao.entity.Language;
import com.swathisprasad.springboot.dao.repository.ILanguageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="Language API", description="Operations pertaining to Language")
@RequestMapping("/api")
public class LanguageController {

    @Autowired
    ILanguageRepository languageRepository;

    @ApiOperation(value = "View a list of available languages", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Language>> getLanguages() {
        final List<Language> languages = languageRepository.findAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

}
