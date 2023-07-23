export interface ICreateBoard {
    title: string,
    contents: string,
    openStatus: OpenStatus
}

export enum OpenStatus {
    All,
    OnlyAdmin
}

export interface IUser {
    nick: string,
    password: string
}

export interface IPublic {
    id?: string;
    category?: string;
    contents: [
        {
            order?: number;
            contentType?: string;
            content: string;
        }
    ];
    title: string | undefined;
    writer?: string;
    openStatus: string;
}

export interface INotice {
    id?: string;
    category?: string;
    contents: [
        {
            order?: number;
            contentType?: string;
            content: string;
        }
    ];
    title: string | undefined;
    writer?: string;
    openStatus: string;
}