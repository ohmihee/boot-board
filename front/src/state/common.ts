import React, {useState} from "react";
import {useMutation, useQuery} from "react-query";
import boardApi from "../api/boardApi";
import {BoardType} from "./type/boardType";

interface IPublic {
    id?: string;
    category?: string;
    contents: [
        {
            order?: number;
            contentType?: string;
            content: string;
        }
    ];
    title: string | undefined;
    writer?: string;
    openStatus: string;
}

export default (id?: string) => {
    const [commonBoard, setCommonBoard] = useState<IPublic>({
        category: "",
        contents: [
            {
                content: "",
            },
        ],
        title: undefined,
        openStatus: "All",
    });
    const {queryKeyAll, queryFnAll} = boardApi.query.findCommonBoardAll();
    // const {queryKeyNotice, queryFnNotice} = boardApi.query.findNoticeBoard()

    if (id) {
        const {queryKeyById, queryFnById} =
            boardApi.query.findCommonBoardById(id);
        useQuery(queryKeyById, queryFnById, {
            onSuccess: (result) => {
                setCommonBoard(result);
            },
        });
    }

    const {data, refetch} = useQuery(queryKeyAll, queryFnAll);
    const register = boardApi.mutation.createCommonBoard;
    const registerMutaion = useMutation(register.mutationFn);

    const editMutation = useMutation(boardApi.mutation.editCommonBoardById.mutationFn)
    const removeMutation = useMutation(boardApi.mutation.removeCommonBoardById.mutationFn);
    const createCommonBoard = (route: () => void) => {
        registerMutaion.mutate(commonBoard, {onSuccess: () => route()});
    };

    const setCommonBoardProperties = (key: keyof IPublic, value: string) => {
        setCommonBoard((prev) => {
            return {
                ...prev,
                [key]: value,
            };
        });
    };

    const setCommonBoardContent = (value: string) => {
        setCommonBoard((prev) => {
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

    const editCommonBoard = (route: () =>void) => {
        //await boardApi.editCommonBoardById(commonBoard)
        editMutation.mutate(commonBoard, {onSuccess: () =>{
                route()
            }})
    }

    const removeCommonBoardById = async (id: string) => {
        await boardApi.removeCommonBoardById(id);
        removeMutation.mutate(id, {onSuccess: () =>{
                // refetch()
            }})

    }


    return {
        data,
        commonBoard,
        refetch,
        createCommonBoard,
        setCommonBoardProperties,
        setCommonBoardContent,
        editCommonBoard,
        removeCommonBoardById
    };
};
