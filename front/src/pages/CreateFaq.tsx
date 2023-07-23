import CreateForm from "../components/common/CreateForm";
import { Link, useLocation, useNavigate } from "react-router-dom";
import faq from "../state/faq";

const CreateFaq = () => {
  //const location = useLocation();
  const { createFaqBoard, setFaqBoard } = faq();
  const navigate = useNavigate();
  const handleChangeQuestion =
    (type: string) => (e: React.ChangeEvent<HTMLInputElement>) => {
      setFaqBoard("question", e.target.value);
    };
  const handleChangeAnswer = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFaqBoard("answer", e.target.value);
  };
  const handleToNoticeList = () => {
    console.log("test===")
    createFaqBoard(() => {
      navigate("/faq");
    });
  };
  return (
    <>
      <CreateForm

        onChangeTitle={handleChangeQuestion}
        onChangeContent={handleChangeAnswer}
        onClickConfirm={handleToNoticeList}
      />
    </>
  );
};

export default CreateFaq;
