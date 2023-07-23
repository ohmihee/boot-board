import { Button, Grid } from "@mui/material";
import { Box } from "@mui/system";
import {DataGrid, GridColDef, GridEventListener, GridSelectionModel,} from "@mui/x-data-grid";
import * as React from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import common from "../state/common";
import {removeQnaBoardById} from "../api/qnaApi";

interface IPublicProps {}

const columns: GridColDef[] = [
  ///{ field: "id", headerName: "id", hideable: true },
  { field: "title", headerName: "title" },
  { field: "createDateTime", headerName: "createdAt" },
  { field: "lastModifiedDate", headerName: "updatedAt" },

];

interface IPublic {
  id?: string;
  category: string;
  contents: [
    {
      order: number;
      contentType: string;
      content: string;
    }
  ];
  title: string;
  writer?: string;
  openStatus: string;
}

const Public: React.FunctionComponent<IPublicProps> = (props) => {
  const [ selectedCheck, setSelectedCheck ] = useState<Array<string>>([])
  const [ page, setPage] = useState<number>(2)
  const { data, removeCommonBoardById, refetch } = common();
  //const apiRef = useGridApiRef();
  const [boardId, setBoardId] = useState<string>("");
  const navigate = useNavigate();

  const handleRowClick: GridEventListener<"rowClick"> = (params) => {
    navigate(`/public/form/${params.id}`);
  };
  const handleSelection = (value: GridSelectionModel) => {
    // @ts-ignore
    setSelectedCheck(value)

  }

  const handleRemove = () => {
    if (selectedCheck.length === data.length) {
      const result = window.confirm("전체 게시물이 삭제 됩니다.");
      if (result) {
        selectedCheck.map(async(ele)=>{
          await removeCommonBoardById(ele)
        })
      }
    } else {
      selectedCheck.map(async(ele)=>{
        await removeCommonBoardById(ele)
      })
    }
    refetch();
  }

  const handleCurrentPage = (e: number) => {
    setPage(e)
  }
  return (
    <>
      <Box sx={{ height: 400, width: "100%" }}>
        <DataGrid
          columns={columns}
          rows={data || []}
          initialState={{
            ...data,
            pagination: { paginationModel: { pageSize: 5 }},

          }}
          pageSize={5}
          checkboxSelection
          onRowClick={handleRowClick}
          onSelectionModelChange={handleSelection}
          onPageChange={handleCurrentPage}
        />
      </Box>
      {/* {data?.map((value: any, index: number) => (
        <div>{}</div>
      ))} */}
      <Box sx={{display: "block", justifyContent:"center",width: "100%"}} >
        <Link to="/public/form">
          <Button
              sx={{ marginTop: 2, backgroundColor: "#1982b3", marginRight: 2 }}
              variant="contained"
          >
            등록
          </Button>
        </Link>
        <Button
            sx={{ marginTop: 2, backgroundColor: "#1982b3" }}
            variant="contained"
            onClick={handleRemove}
        >
          삭제
        </Button>
      </Box>
    </>
  );
};

export default Public;
