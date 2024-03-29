import { INotice } from "../state/type/INoticeType";
import { deleteApi, getApi, postApi } from "./api";

const findNoticeBoardAll = () => getApi("api/board/notice").then();

const createNoticeBoard = (data: any) => postApi("board/notice", data);

const findNoticeBoardById = (id: string) => getApi(`board/notice/${id}`);

const editNoticeBoardById = (data: any) => postApi("board/notice/edit", data);

const removeNoticeBoardById = (id: string) => deleteApi(`board/notice/${id}`);

export default {
  findNoticeBoardAll,
  createNoticeBoard,
  findNoticeBoardById,
  editNoticeBoardById,
  removeNoticeBoardById,
  query: {
    findNoticeBoardAll: () => ({
      queryKey: "board-notice",
      queryFn: async () => await findNoticeBoardAll(),
    }),
    findNoticeBoardById: (id: string) => ({
      queryKeyById: "board-notice-id",
      queryFnById: async () => await findNoticeBoardById(id).then(),
    }),
  },
  mutation: {
    createNoticeBoard: {
      mutationFn: async (data: INotice) => await createNoticeBoard(data),
    },
    editNoticeBoardById: {
      mutationFn: async (id: string) => await editNoticeBoardById(id)
    },
    removeNoticeBoardById: {
      mutationFn: async (id: string) => await removeNoticeBoardById(id)
    }
  },
};
