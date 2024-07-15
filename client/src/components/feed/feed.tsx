import InfiniteScroll from "react-infinite-scroll-component";
import { ReactNode, useEffect } from "react";
import { QueryFunction, QueryKey, useQuery } from "@tanstack/react-query";
import { PaginationResponse } from "@/common/pagination/pagination-response.model";
import { toast } from "sonner";
import { cn } from "@/lib/utils";

type Props<T> = {
  ListComponent: React.ComponentType<{ data: T[] }>;
  endMessage?: ReactNode;
  queryFn: QueryFunction<PaginationResponse<T>>;
  queryKey: QueryKey;
  generateMore: () => void;
  className?: string;
};

const Feed = <T extends object>({
  queryFn,
  queryKey,
  ListComponent,
  generateMore,
  endMessage = (
    <p className="pt-5 px-4 font-semibold">No more data available</p>
  ),
  className,
}: Props<T>) => {
  const { data, error } = useQuery({
    queryFn,
    queryKey,
  });

  const hasMore: boolean = !data || data?.page === data?.totalPages;

  useEffect(() => {
    if (error?.message) {
      toast.error("Error getting feed", {
        description: error.message,
      });
    }
  }, [error?.message]);

  return (
    <div className={cn("flex flex-col gap-3 p-0 md:p-3 lg:p-0", className)}>
      <div role="feed">
        <InfiniteScroll
          dataLength={data?.results.length ?? 0}
          next={generateMore}
          loader={
            <ul>
              <li className="px-5 pb-5">LOADING</li>
            </ul>
          }
          hasMore={hasMore}
          endMessage={endMessage}
        >
          <ListComponent data={data?.results ?? []} />
        </InfiniteScroll>
      </div>
      {/* <ScrollTopButton
        className="hidden lg:flex justify-center items-center"
        hasAnimation={!hasMore}
      /> */}
    </div>
  );
};

export default Feed;
