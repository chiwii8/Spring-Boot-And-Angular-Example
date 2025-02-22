export class User {
    public username: string;
    public password: string;
    public active: boolean;
    constructor(){
        this.username = ''
        this.password = ''
        this.active = false;
    }


    setUserData(username:string, password:string, active: boolean){
        this.username = username;
        this.password = password;
        this.active = active;
    }
}
