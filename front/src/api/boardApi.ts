import { deleteApi, getApi, postApi } from './api';

export const findCommonBoardAll = () =>
    getApi("board");

export const createCommonBoard = (data: any) =>
    postApi("board", data);

export const findCommonBoardById = (id: string) => 
    getApi(`board/${id}`,);

export const editCommoonBoardById = (data: any) =>
    postApi("board/edit", data);

export const removeCommonBoardById = (id: string) => 
    deleteApi(`board/${id}`)
