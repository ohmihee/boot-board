import { ICreateBoard } from "../types/type";
import { deleteApi, getApi, postApi } from "./api";

export const findQnaBoardAll = () => getApi("board/qna").then();

export const createQnaBoard = (data: ICreateBoard) =>
  postApi("board/qna", data);

export const findQnaBoardById = (id: string) => getApi(`board/qna/${id}`);

export const editQnaBoardById = (data: any) => postApi("board/qna/edit", data);

export const removeQnaBoardById = (id: string) => deleteApi(`board/qna/${id}`);

export default {
  query: {
    findQnaBoardAll: () => ({
      queryKey: "board-qna",
      queryFn: async () => await findQnaBoardAll(),
    }),
  },
};
