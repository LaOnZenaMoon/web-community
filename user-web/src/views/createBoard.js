import Board from "@/views/Board";

export default function createBoard(name) {
  return {
    name,
    render(createElement) {
      return createElement(Board);
    }
  }
}
