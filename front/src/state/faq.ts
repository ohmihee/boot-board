import { useQuery } from "react-query";
import faq from "../api/faq";

export default () => {
  const { queryKey, queryFn } = faq.query.findFaqBoardAll();

  const { data } = useQuery(queryKey, queryFn);

  return {
    data,
  };
};
