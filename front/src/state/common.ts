import React, { useState } from "react";
import { useMutation, useQuery } from "react-query";
import boardApi from "../api/boardApi";
import { BoardType } from "./type/boardType";

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

export default () => {
  const [commonBoard, setCommonBoard] = useState<IPublic>({
    category: "",
    contents: [
      {
        content: "",
      },
    ],
    title: "",
    writer: "",
    openStatus: "All",
  });
  const { queryKey, queryFn } = boardApi.query.findCommonBoardAll();

  const { data } = useQuery(queryKey, queryFn);

  const register = boardApi.mutation.createCommonBoard;
  const registerMutaion = useMutation(register.mutationFn);

  const createCommonBoard = (route: () => void) => {
    console.log(commonBoard, "commonboard===");
    registerMutaion.mutate(commonBoard, { onSuccess: () => route() });
  };

  const setCommonBoardTitle = (key: keyof IPublic, value: string) => {
    setCommonBoard((prev) => {
      return {
        ...prev,
        [key]: value,
      };
    });
  };

  const setCommonBoardContent = (value: string) => {
    setCommonBoard((prev) => {
      return {
        ...prev,
        contents: [
          {
            content: value,
          },
        ],
      };
    });
  };
  //   const [boardType, setBoardType] = React.useState(
  //     boardTypeAtom(BoardType.Public)
  //   );
  //   return {
  //     boardType,
  //     setBoardType,
  //   };
  return {
    data,
    createCommonBoard,
    setCommonBoardTitle,
    setCommonBoardContent,
  };
};
