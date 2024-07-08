import { Question } from "./question.model";

export interface Quiz {
  id: string;
  title: string;
  prompt: string;
  questions: Question[];
  createdAt: Date;
  updatedAt: Date;
}
