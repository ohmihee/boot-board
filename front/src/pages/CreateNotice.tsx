import CreateForm from "../components/common/CreateForm";
import { Link, useLocation, useNavigate } from "react-router-dom";
import Notice from "./Notice";
import notice from "../state/notice";
import common from "../state/common";
import {useEffect} from "react";

const CreateNotice = () => {
  //const location = useLocation();
  // const { createNoticeBoard, setNoticeBoardTitle, setNoticeBoardContent } =
  //   notice();
  const { data } = notice()
  const { createCommonBoard, setCommonBoardProperties,setCommonBoardContent } =
    common();
  const navigate = useNavigate();

  useEffect(() => {
    setCommonBoardProperties("category","notice")
  },[])
  const handleChangeTitle =
    (key: string) => (e: React.ChangeEvent<HTMLInputElement>) => {
      //setNoticeBoardTitle("title", e.target.value);
      setCommonBoardProperties("title", e.target.value)
    };
  const handleChangeContent = (e: React.ChangeEvent<HTMLInputElement>) => {
    //setNoticeBoardContent(e.target.value);
    setCommonBoardContent(e.target.value);
  };
  const handleToNoticeList = () => {
    // createNoticeBoard(() => {
    //   navigate("/notice");
    // });
    console.log("test===")

    createCommonBoard(()=> navigate("/notice"))
  };
  return (
    <>
      <CreateForm
         // value={data}
        onChangeTitle={handleChangeTitle}
        onChangeContent={handleChangeContent}
        onClickConfirm={handleToNoticeList}
      />
    </>
  );
};

export default CreateNotice;
