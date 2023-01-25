import { ICreateBoard } from '../types/type';
import { deleteApi, getApi, postApi } from './api';

export const findCommonBoardAll = () =>
    getApi("board/qna");

export const createCommonBoard = (data: ICreateBoard) =>
    postApi("board/qna", data);

export const findCommonBoardById = (id: string) => 
    getApi(`board/qna/${id}`,);

export const editCommoonBoardById = (data: any) =>
    postApi("board/qna/edit", data);

export const removeCommonBoardById = (id: string) => 
    deleteApi(`board/qna/${id}`)
