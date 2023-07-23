import { useState } from "react";
import { useMutation, useQuery } from "react-query";
import noticeApi from "../api/noticeApi";
import { INotice } from "./type/INoticeType";
import boardApi from "../api/boardApi";
import {IPublic} from "../types/type";

export default () => {
  const [noticeBoard, setNoticeBoard] = useState<INotice>({
    title: "",
    contents: [
      {
        content: "",
      },
    ],
    openStatus: "All",
  });
  //const { queryKey, queryFn } = noticeApi.query.findNoticeBoardAll();
  const {queryKeyNotice, queryFnNotice } = boardApi.query.findNoticeBoard();
  const { data }= useQuery(queryKeyNotice, queryFnNotice);

  const register = noticeApi.mutation.createNoticeBoard;
  const registerMutation = useMutation(register.mutationFn);

  const createNoticeBoard = (route: () => void) => {
    registerMutation.mutate(noticeBoard, {
      onSuccess: () => {
        route();
      },
    });
  };
  const setNoticeBoardTitle = (key: keyof INotice, value: string) => {
    setNoticeBoard((prev) => {
      return {
        ...prev,
        [key]: value,
      };
    });
  };

  const setNoticeBoardContent = (value: string) => {
    setNoticeBoard((prev) => {
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

  return {
    data,
    createNoticeBoard,
    setNoticeBoardTitle,
    setNoticeBoardContent,
  };
};
