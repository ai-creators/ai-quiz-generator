package com.aiquizgenerator.backend.generator;

import lombok.Data;

@Data
public class Prompt {
    private String prompt;

    private String lengthRule;

    private final String promptRules = """
        Create a quiz based on this prompt. 
        Each question should have 4 multiple-choice answers with one correct answer. 
        The response must be in JSON format. Only return the json object. Dont include the json strings before and after the json object, just the object itself.
        Include in the JSON response a property of categories that is an array of strings of what the category is. 
        Furthermore, include a property isPg that is a boolean value if the quiz is PG rated. 
        The quiz should be a property of questions and is of type array containing question objects. 
        Each question object should have a property question and an array of answers, where each answer is an object with properties answer and isCorrect. 
        Also include a property of title that is the title of the quiz.
    """;

    private final String example = """
        {
            "title": "Taylor Swift Quiz",
            "questions": [
                {
                    "question": "What is the name of Taylor Swift's debut album?",
                    "answers": [
                        {
                            "answer": "Fearless",
                            "isCorrect": false
                        },
                        {
                            "answer": "Red",
                            "isCorrect": false
                        },
                        {
                            "answer": "Taylor Swift",
                            "isCorrect": true
                        },
                        {
                            "answer": "1989",
                            "isCorrect": false
                        }
                    ]
                },
                {
                    "question": "In what year was Taylor Swift born?",
                    "answers": [
                        {
                            "answer": "1989",
                            "isCorrect": true
                        },
                        {
                            "answer": "1990",
                            "isCorrect": false
                        },
                        {
                            "answer": "1991",
                            "isCorrect": false
                        },
                        {
                            "answer": "1988",
                            "isCorrect": false
                        }
                    ]
                },
                {
                    "question": "Which song is not by Taylor Swift?",
                    "answers": [
                        {
                            "answer": "Love Story",
                            "isCorrect": false
                        },
                        {
                            "answer": "Bad Blood",
                            "isCorrect": false
                        },
                        {
                            "answer": "Halo",
                            "isCorrect": true
                        },
                        {
                            "answer": "Shake It Off",
                            "isCorrect": false
                        }
                    ]
                },
                {
                    "question": "What is Taylor Swift's middle name?",
                    "answers": [
                        {
                            "answer": "Alison",
                            "isCorrect": true
                        },
                        {
                            "answer": "Marie",
                            "isCorrect": false
                        },
                        {
                            "answer": "Lynn",
                            "isCorrect": false
                        },
                        {
                            "answer": "Ann",
                            "isCorrect": false
                        }
                    ]
                },
                {
                    "question": "Which Taylor Swift album features the song 'Blank Space'?",
                    "answers": [
                        {
                            "answer": "Fearless",
                            "isCorrect": false
                        },
                        {
                            "answer": "Speak Now",
                            "isCorrect": false
                        },
                        {
                            "answer": "1989",
                            "isCorrect": true
                        },
                        {
                            "answer": "Reputation",
                            "isCorrect": false
                        }
                    ]
                }
            ],
            "categories": ["Music", "Pop Culture"],
            "isPg": true
        }
    """;

    public String build() {
        return String.format("%s The prompt is: \"%s\". Here is an example of the desired format: %s", promptRules, prompt, example);
    }
}
