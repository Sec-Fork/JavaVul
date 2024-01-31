package com.myapp.controller;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.expression.spel.support.SimpleEvaluationContext;


@RestController
public class SpelController {
    @GetMapping("/spel_expression")
    public String spelInjection(@RequestParam String input) {
        ExpressionParser expressionParser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Expression expression = expressionParser.parseExpression(input);
        Object object = expression.getValue(context);
        return object.toString();
    }
}