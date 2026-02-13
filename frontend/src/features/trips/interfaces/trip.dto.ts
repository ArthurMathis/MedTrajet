/**
 * @interface TripDto
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export interface TripDto {
    id: number;
    userId: number;
    destinationId: number;
    startMileage: number;
    endMileage: number;
    startedAt: string;
    endedAt: string;
}