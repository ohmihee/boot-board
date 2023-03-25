import { deleteApi, getApi, postApi } from "./api";

const findCommonBoardAll = () => getApi("board").then();

const createCommonBoard = (data: any) => postApi("board", data).then();

const findCommonBoardById = (id: string) => getApi(`board/${id}`);

const editCommoonBoardById = (data: any) => postApi("board/edit", data);

const removeCommonBoardById = (id: string) => deleteApi(`board/${id}`);

interface IPublic {
  category?: string;
  contents: [
    {
      order?: number;
      contentType?: string;
      content: string;
    }
  ];
  title: string | undefined;
  writer?: string;
  openStatus: string;
}

export default {
  findCommonBoardAll,
  createCommonBoard,
  findCommonBoardById,
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
  },
  mutation: {
    createCommonBoard: {
      mutationFn: async (data: IPublic) => await createCommonBoard(data),
    },
  },
};
