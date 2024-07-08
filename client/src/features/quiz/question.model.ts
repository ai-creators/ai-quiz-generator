import { Answer } from "./answer.model";

export interface Question {
  id: number;
  question: string;
  answers: Answer[];
}
