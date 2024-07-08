import { Api } from "@/api/api";
import { AxiosRequestConfig } from "axios";
import { Quiz } from "../quiz.model";

export class QuizService extends Api {
  private static instance: QuizService;

  constructor() {
    super();
  }

  public static getInstance(): QuizService {
    if (!QuizService.instance) {
      QuizService.instance = new QuizService();
    }
    return QuizService.instance;
  }

  public create(accessToken: string, prompt: string): Promise<Quiz> {
    const config: AxiosRequestConfig = {
      url: "/api/v1/quiz",
      method: "POST",
      data: {
        prompt,
      },
      headers: {
        "content-type": "application/json",
        Authorization: `Bearer ${accessToken}`,
      },
    };

    return this.callExternalApi<Quiz>({ config });
  }
}
