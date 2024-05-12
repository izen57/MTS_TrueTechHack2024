export interface BackendResponse {
  userId: number;
  username: string;
  comments: object[];
  preference: boolean;
	credentials: boolean;
}

interface HttpResponse<T> extends Response {
  parsed?: T;
}

export async function call<T>(request: RequestInfo): Promise<HttpResponse<T>> {
	try {
		const response: HttpResponse<T> = await fetch(request, {
			headers: new Headers({
				'Access-Control-Allow-Origin': '*'
			}),
		});
		if (!response.ok) {
			throw new Error(response.statusText);
		}
		return await response.json();
	} catch (e) {
		throw e;
	}
}

export type ButtonProps = {
  onClick?: (event: React.MouseEvent<HTMLButtonElement>) => void;
  children?: React.ReactNode;
	as?: "button" | "div";
	isDisabled?: boolean;
	isLoading?: boolean;
};

function Button({
	children,
	isDisabled = false,
	isLoading = false,
	onClick
}: ButtonProps) {
	return (
		<div>
			<button onClick={onClick}>
				{children}
			</button>
		</div>
	);
}

export default Button;
