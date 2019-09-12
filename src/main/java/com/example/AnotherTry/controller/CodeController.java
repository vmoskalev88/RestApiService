package com.example.AnotherTry.controller;

import com.example.AnotherTry.model.Code;
import com.example.AnotherTry.service.CodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// todo НЕ ДОПИСАН
@RestController
@RequestMapping("api/codes")
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Code> getCode(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Code code = codeService.getById(id);
        if (code == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Code> createCode(@RequestBody Code code) {
        if (code == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        codeService.save(code);
        return new ResponseEntity<>(code, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Code> updateCode(@RequestBody Code code) {
        if (code == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        codeService.save(code);
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Code> deleteCode(@PathVariable("id") Long id) {
        Code code = codeService.getById(id);
        if (code == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        codeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Code>> getAllCodes() {
        List<Code> codes = codeService.getAll();

        if (codes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(codes, HttpStatus.OK);
    }

}
