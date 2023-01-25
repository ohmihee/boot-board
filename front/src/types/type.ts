export interface ICreateBoard {
    title: string,
    contents: string,
    openStatus: OpenStatus
}

export enum OpenStatus {
    All,
    OnlyAdmin
}