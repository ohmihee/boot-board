export interface INotice {
  id?: string;
  title: string;
  contents: [
    {
      order?: number;
      contentType?: string;
      content: string;
    }
  ];
  wirter?: string;
  openStatus: string;
}
