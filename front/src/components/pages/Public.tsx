import { Grid } from "@mui/material";
import { Box } from "@mui/system";
import { DataGrid, GridColDef } from "@mui/x-data-grid";
import * as React from "react";

interface IPublicProps {}

const rows = [
  { id: 1, number: 1, title: "test", date: "2022-12-12" },
  { id: 2, number: 2, title: "test", date: "2022-12-12" },
  { id: 3, number: 3, title: "test", date: "2022-12-12" },
];

const columns: GridColDef[] = [
  { field: "number", headerName: "num" },
  { field: "title", headerName: "title" },
  { field: "date", headerName: "date" },
];

const Public: React.FunctionComponent<IPublicProps> = (props) => {
  return (
    <Box sx={{ height: 400, width: "100%" }}>
      <DataGrid columns={columns} rows={rows} rowsPerPageOptions={[5]} />
    </Box>
  );
};

export default Public;
