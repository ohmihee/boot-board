import {Grid, Typography} from "@mui/material";
import {useLocation, useSearchParams} from "react-router-dom";
import common from "../state/common";
import {Box} from "@mui/system";

const PublicDetail = () => {
    const [searchParams] = useSearchParams();
    const query = searchParams.get('id');
    const {
        commonBoard,
    } = common(query || undefined);

    return (
        <Grid sx={{width: "100%", mt: 3}}>
            <Box sx={{display: "flex", alignContent: "left"}}>
                <Typography variant="h5" gutterBottom sx={{fontWeight: 500}}>
                    {commonBoard.title}
                </Typography>
            </Box>
            <div className="line"></div>
            <Typography variant="body2" gutterBottom sx={{textAlign: "right", mt:1}}>
                {commonBoard.writer}오미희
            </Typography>
            <Box sx={{display: "flex", alignContent: "left", mt: 2}}>
                <Typography variant="body1" gutterBottom>
                    {commonBoard.contents[0].content}
                </Typography>
            </Box>


        </Grid>
    )
}

export default PublicDetail