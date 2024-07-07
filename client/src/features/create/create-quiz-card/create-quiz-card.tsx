import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import TypographyH2 from "@/components/ui/typography/typography-h2";

const CreateQuizCard = () => {
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
          <Input placeholder="Taylor Swift Facts..." />
        </div>

        <div>
          <Button>Create Quiz</Button>
        </div>
      </form>
    </Card>
  );
};

export default CreateQuizCard;
