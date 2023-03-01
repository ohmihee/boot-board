import { deleteApi, getApi, postApi } from "./api";

const findFaqBoardAll = () => getApi("board/faq").then();

const createFaqBoard = (data: any) => postApi("board/faq", data);

const findFaqBoardById = (id: string) => getApi(`board/faq/${id}`);

const editFaqBoardById = (data: any) => postApi("board/faq/edit", data);

const removeFaqBoardById = (id: string) => deleteApi(`board/fqa/${id}`);

export default {
  findFaqBoardAll,
  query: {
    findFaqBoardAll: () => ({
      queryKey: "board-faq",
      queryFn: async () => await findFaqBoardAll(),
    }),
  },
};
