import { IFaq } from "../state/type/IFaq";
import { deleteApi, getApi, postApi } from "./api";

const findFaqBoardAll = () => getApi("board/faq").then();

const createFaqBoard = (data: any) => postApi("board/faq", data);

const findFaqBoardById = (id: string) => getApi(`board/faq/${id}`);

const editFaqBoardById = (data: any) => postApi("board/faq/edit", data);

const removeFaqBoardById = (id: string) => deleteApi(`board/fqa/${id}`);

export default {
  findFaqBoardAll,
  findFaqBoardById,
  createFaqBoard,
  editFaqBoardById,
  removeFaqBoardById,
  query: {
    findFaqBoardAll: () => ({
      queryKey: "board-faq",
      queryFn: async () => await findFaqBoardAll(),
    }),
    findFaqBoardById: () => ({
      queryKey: "faq-read-id",
      queryFn: async (id: string) => await findFaqBoardById(id)
    })
  },
  mutation: {
    createFaqBoard: {
      mutationFn: async (data: IFaq) => await createFaqBoard(data),
    },
    editFaqBoardById: {
      mutationFn: async (data: IFaq) => await editFaqBoardById(data)
    },
    removeFaqBoardById: {
      mutationFn: async (id: string) => await removeFaqBoardById(id)
    }
  },
};
