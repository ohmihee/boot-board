import { deleteApi, getApi, postApi } from "./api";

const findNoticeBoardAll = () => getApi("board/notice").then();

const createNoticeBoardAll = (data: any) => postApi("board/notice", data);

const findNoticeBoardById = (id: string) => getApi(`board/notice/${id}`);

const editNoticeBoardById = (data: any) => postApi("board/notice/edit", data);

const removeNoticeBoardById = (id: string) => deleteApi(`board/notice/${id}`);

export default {
  findNoticeBoardAll,
  query: {
    findNoticeBoardAll: () => ({
      queryKey: "board-notice",
      queryFn: async () => await findNoticeBoardAll(),
    }),
  },
};
