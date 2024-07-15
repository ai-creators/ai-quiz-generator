import { buttonVariants } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import TypographyH4 from "@/components/ui/typography/typography-h4";
import { Quiz } from "@/features/quiz/quiz.model";
import { cn } from "@/lib/utils";
import { Link } from "react-router-dom";

type Props = {
  quiz: Quiz;
};

const QuizzesCard = ({ quiz }: Props) => {
  return (
    <Card>
      <TypographyH4>{quiz.title}</TypographyH4>
      <Link
        to={`/quiz/${quiz.id}`}
        className={cn(buttonVariants({ variant: "default" }), "w-24")}
      >
        Go to quiz
      </Link>
    </Card>
  );
};

export default QuizzesCard;
