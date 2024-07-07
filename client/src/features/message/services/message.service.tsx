import { Api } from "@/api/api";
import { AxiosRequestConfig } from "axios";

export class MessageService extends Api {
    private static instance: MessageService;

    constructor() {
        super();
    }

    public static getInstance(): MessageService {
        if (!MessageService.instance) {
        MessageService.instance = new MessageService();
        }
        return MessageService.instance;
    }

    public getPublic(){
        const config: AxiosRequestConfig = {
            url: "/api/messages/public",
            headers: {
                "content-type": "application/json",
              },
        }

        return this.callExternalApi<string>({ config});
    }

    public getProtected(accessToken: string){
        const config: AxiosRequestConfig = {
            url: "/api/messages/protected",
            headers: {
                "content-type": "application/json",
                Authorization: `Bearer ${accessToken}`,
              },
        }

        return this.callExternalApi<string>({ config});}

    public getAdmin(accessToken: string){
        const config: AxiosRequestConfig = {
            url: "/api/messages/admin",
            headers: {
                "content-type": "application/json",
                Authorization: `Bearer ${accessToken}`,
              },
        }

        return this.callExternalApi<string>({ config});}
}