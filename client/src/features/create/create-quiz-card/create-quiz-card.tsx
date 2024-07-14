import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import TypographyH2 from "@/components/ui/typography/typography-h2";
import { QuizService } from "@/features/quiz/services/quiz.service";
import { useAuth0 } from "@auth0/auth0-react";
import { useMutation } from "@tanstack/react-query";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "sonner";

const CreateQuizCard = () => {
  const { getAccessTokenSilently } = useAuth0();

  const navigate = useNavigate();

  const [prompt, setPrompt] = useState<string>("");

  const changePrompt = (value: string) => {
    setPrompt(value);
  };

  const {
    mutate: createQuiz,
    isPending,
    error,
  } = useMutation({
    mutationKey: ["create-quiz"],
    mutationFn: async (event: React.MouseEvent) => {
      event.preventDefault();

      const accessToken = await getAccessTokenSilently();

      const createdQuiz = await QuizService.getInstance().create(
        accessToken,
        prompt
      );

      if (createdQuiz?.id) {
        navigate(`/quiz/${createdQuiz.id}`);
      }

      return null;
    },
  });

  useEffect(() => {
    if (error?.message) {
      toast("Error creating quiz", {
        description: error.message,
      });
    }
  }, [error?.message]);

  useEffect(() => {
    if (isPending) {
      toast("Loading...");
    }
  }, [isPending]);

  return (
    <Card>
      <header className="p-5">
        <TypographyH2 border="">Create a Quiz</TypographyH2>
      </header>
      <form className="flex flex-col gap-5 px-5 pb-5">
        <div className="flex flex-col gap-3">
          <Label className="text-muted-foreground">
            Enter a prompt to create a quiz
          </Label>
          <Input
            placeholder="Taylor Swift Facts..."
            value={prompt}
            onChange={({ target: { value } }) => changePrompt(value)}
          />
        </div>

        <div>
          <Button onClick={(e) => createQuiz(e)} disabled={isPending}>
            Create Quiz
          </Button>
        </div>
      </form>
    </Card>
  );
};

export default CreateQuizCard;
