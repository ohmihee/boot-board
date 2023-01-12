import { getApi, postApi } from './api';

export const getCommonBoard = (params: string | null ) =>
    getApi("board", params);

export const postCommonBoard = (data: any) =>
    postApi("board", null);