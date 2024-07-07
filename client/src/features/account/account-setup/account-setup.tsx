import { Card } from "@/components/ui/card";
import AccountSetupForm from "./account-setup-form/account-setup-form";
import { useEffect } from "react";
import { MessageService } from "@/features/message/services/message.service";
import { useAuth0 } from "@auth0/auth0-react";

const AccountSetup = () => {
  const { getAccessTokenSilently } = useAuth0();

  useEffect(() => {
    (async() => {
      const accessToken = await getAccessTokenSilently();
      const instance = MessageService.getInstance();
      console.log(await instance.getPublic());
      console.log(await instance.getProtected(accessToken));
      console.log(await instance.getAdmin(accessToken));
    })();
    
  }, [])
  return (
    <Card className="max-w-7xl p-5 h-fit flex flex-col gap-8">
      <div>
        <h2 className="font-semibold">Welcome to the QuizBot Community</h2>
      </div>

      <AccountSetupForm />
    </Card>
  );
};

export default AccountSetup;
