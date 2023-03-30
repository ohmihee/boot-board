import { useState } from "react";
import { useMutation, useQuery } from "react-query";
import faq from "../api/faq";
import { IFaq } from "./type/IFaq";

export default () => {
  const [faqBoard, setFqaBoard] = useState<IFaq>({
    question: "",
    answer: "",
  });
  const { queryKey, queryFn } = faq.query.findFaqBoardAll();

  const { data } = useQuery(queryKey, queryFn);

  const register = faq.mutation.createFaqBoard;
  const registerMutation = useMutation(register.mutationFn);

  const createFaqBoard = (route: () => void) => {
    registerMutation.mutate(faqBoard, {
      onSuccess: () => {
        route();
      },
    });
  };

  const setFaqBoard = (key: keyof IFaq, value: string) => {
    setFqaBoard((prev) => {
      return {
        ...prev,
        [key]: value,
      };
    });
  };

  const remoeFaqBoard = (id: string) => {
    faq.removeFaqBoardById(id);
  }

  return {
    data,
    createFaqBoard,
    setFaqBoard,
  };
};
