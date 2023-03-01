import { useQuery } from "react-query";
import noticeApi from "../api/noticeApi";

export default () => {
  const { queryKey, queryFn } = noticeApi.query.findNoticeBoardAll();
  const { data } = useQuery(queryKey, queryFn);

  return { data };
};
