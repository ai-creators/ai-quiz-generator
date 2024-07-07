import CreateQuizCard from "@/features/create/create-quiz-card/create-quiz-card";
import Container from "@/layout/container/container";
import Layout from "@/layout/layout";

const DashboardPage = () => {
  return (
    <Layout>
      <Container className="grid grid-cols-12 gap-5 py-10 max-w-5xl">
        <section className="col-span-12">
          <CreateQuizCard />
        </section>
      </Container>
    </Layout>
  );
};

export default DashboardPage;
