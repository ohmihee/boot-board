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
  title: string;
  writer?: string;
  openStatus: string;
}

export default {
  findCommonBoardAll,
  query: {
    findCommonBoardAll: () => ({
      queryKey: "board-public",
      queryFn: async () => await findCommonBoardAll(),
    }),
  },
  mutation: {
    createCommonBoard: {
      mutationFn: async (data: IPublic) => await createCommonBoard(data),
    },
  },
};
