package com.aiquizgenerator.backend.generator.dto;

import java.util.List;

public class ChatResponse {

    private List<Choice> choices;

    public List<Choice> getChoices(){
        return choices;
    }
    
    public static class Choice {

        private int index;
        private Message message;

        public int getIndex(){
            return index;
        }

        public Message getMessage(){
            return message;
        }
    }
}