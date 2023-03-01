import { useQuery } from "react-query";
import qnaApi from "../api/qnaApi";

export default () => {
  const { queryKey, queryFn } = qnaApi.query.findQnaBoardAll();
  const { data } = useQuery(queryKey, queryFn);

  return {
    data,
  };
};
