import { deleteApi, getApi, postApi } from "./api";
import {IPublic} from "../types/type";

const path = "api/board"
const findCommonBoardAll = () => getApi(path).then();

const createCommonBoard = (data: IPublic) => postApi(path, data).then();

const findCommonBoardById = (id: string) => getApi(`${path}/${id}`);

const editCommonBoardById = (data: IPublic) => postApi(`${path}/edit`, data);

const removeCommonBoardById = (id: string) => deleteApi(`${path}/${id}`);

const findNoticeBoard = () => getApi(`${path}/category/notice`).then();
export default {
  findCommonBoardAll,
  createCommonBoard,
  findCommonBoardById,
  editCommonBoardById,
  removeCommonBoardById,
  findNoticeBoard,
  query: {
    findCommonBoardAll: () => ({
      queryKeyAll: "board-public",
      queryFnAll: async () => await findCommonBoardAll(),
      // queryFnAll: async () =>
      //   await fetch("http://localhost:8080/board").then((res) => res.json()),
    }),
    findCommonBoardById: (id: string) => ({
      queryKeyById: "board-read-id",
      queryFnById: async () => await findCommonBoardById(id).then(),
    }),
    findNoticeBoard: () => ({
      queryKeyNotice: "board-notice",
      queryFnNotice: async () => await findNoticeBoard().then()
    })
  },
  mutation: {
    createCommonBoard: {
      mutationFn: async (data: IPublic) => await createCommonBoard(data),
    },
    editCommonBoardById: {
      mutationFn: async (data: IPublic) => await editCommonBoardById(data)
    },
    removeCommonBoardById: {
      mutationFn: async (id: string) => await removeCommonBoardById(id)
    }
  },
};
