import { Card } from "@/components/ui/card";
import TypographyH3 from "@/components/ui/typography/typography-h3";
import TypographyMuted from "@/components/ui/typography/typography-muted";
import { useQuery } from "@tanstack/react-query";
import { useEffect, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { toast } from "sonner";
import { QuizService } from "../quiz/services/quiz.service";
import Feed from "@/components/feed/feed";
import { PaginationResponse } from "@/common/pagination/pagination-response.model";
import { Quiz } from "../quiz/quiz.model";
import QuizzesList from "./quizzes-list/quizzes-list";

const Quizzes = () => {
  const [searchParams] = useSearchParams();
  const navigate = useNavigate();

  const page = +(searchParams.get("page") ?? 1);
  const [size, setSize] = useState<number>(50);
  const [timestamp] = useState<Date>(new Date());

  const changeSize = (newSize: string) => {
    setSize(+newSize);
  };

  const queryKey = ["quizzes", page, size, timestamp];

  const queryFn = async (): Promise<PaginationResponse<Quiz>> => {
    return await QuizService.getInstance().getPageable(page, size, timestamp);
  };

  const generateMore = () => {};

  return (
    <Card className="flex flex-col gap-5">
      <header className="p-5">
        <TypographyH3>Quizzes</TypographyH3>
        <TypographyMuted>View recently created quizzes</TypographyMuted>
      </header>
      <Feed
        ListComponent={QuizzesList}
        queryFn={queryFn}
        queryKey={queryKey}
        generateMore={generateMore}
      />
    </Card>
  );
};

export default Quizzes;
